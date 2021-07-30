function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}


var messageApi = Vue.resource('/interviews{/id}');

Vue.component('message-form', {
    props: ['messages', 'messageAttr'],
    data: function() {
        return {
            name: '',
            start: '',
            finish: '',
            state: '',
            id: ''
        }
    },
    watch: {
        messageAttr: function(newVal, oldVal) {
            this.name = newVal.name;
            this.start = newVal.start;
            this.finish = newVal.finish;
            this.state = newVal.state;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="имя опроса: опрос №-1" v-model="name" style="margin-bottom: 5px; min-width: 300px;" /><br>' +
        '<input type="text" placeholder="начало: 2021-06-25T05:30:00.144+00:00" v-model="start" style="margin-bottom: 5px; min-width: 300px;" /><br>' +
        '<input type="text" placeholder="окончание: 2021-07-30T17:00:00.144+00:00" v-model="finish" style="margin-bottom: 5px; min-width: 300px;" /><br>' +
        '<input type="text" placeholder="статус: ACTIVE or INACTIVE" v-model="state" style="margin-bottom: 5px; min-width: 300px;" /><br>' +
        '<input type="button" value="Save" @click="save" style="margin-bottom: 5px" /><hr>' +
        '</div>',
    methods: {
        save: function() {
            var message = { name: this.name, start: this.start, finish: this.finish, state: this.state };

            if (this.id) {
                messageApi.update({id: this.id}, message).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.messages, data.id);
                        this.messages.splice(index, 1, data);
                        this.name = '';
                        this.start = '';
                        this.finish = '';
                        this.state = '';
                        this.id = '';
                    })
                )
            } else {
                messageApi.save({}, message).then(result =>
                    result.json().then(data => {
                        this.messages.push(data);
                        this.name = '';
                        this.start = '';
                        this.finish = '';
                        this.state = '';
                    })
                )
            }
        }
    }
});

Vue.component('message-row', {
    props: ['message', 'editMethod', 'messages'],
    template: '<div>' +
        '<i>({{ message.id }})</i> {{ message.name }} {{ message.start }} {{ message.finish }} {{ message.state }}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="edit" style="margin-right: 5px" />' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        edit: function() {
            this.editMethod(this.message);
        },
        del: function() {
            messageApi.remove({id: this.message.id}).then(result => {
                if (result.ok) {
                    this.messages.splice(this.messages.indexOf(this.message), 1)
                }
            })
        }
    }
});

Vue.component('messages-list', {
    props: ['messages'],
    data: function() {
        return {
            message: null
        }
    },
    template:
        '<div style="position: relative; width: 700px;">' +
        '<message-form :messages="messages" :messageAttr="message" />' +
        '<message-row v-for="message in messages" :key="message.id" :message="message" ' +
        ':editMethod="editMethod" :messages="messages" style="margin-bottom: 10px" />' +
        '</div>',
    created: function() {
        messageApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.messages.push(message))
            )
        )
    },
    methods: {
        editMethod: function(message) {
            this.message = message;
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" />',
    data: {
        messages: []
    }
});