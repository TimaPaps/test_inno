настройка в IntelliJ IDEA Ultimate Edition

1 создать в PostgreSQL базу данных с именем ptv_rest

2 изменить в application.properties настройки подключения к базе данных:
    2.1 изменить пользователя: username=tima -> username=новый пользователь 
    2.2 изменить пароль:       password= -> password=новый пароль

3 подключить базу данных к проекту в IntelliJ

4 после запуска проекта открыть в браузере страницу:
4.1http://localhost:8080/
4.2 http://localhost:8080/interviews
4.3 http://localhost:8080/interviews/1
4.4 http://localhost:8080/pollQuestions
4.5 http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/