Сделать клон данного репозитория
Открыть Intelij Idea и в командной строке Maven прописать следующее:

mvn clean test 
-Dbase.api.login=?
-Dbase.api.password=?
-Dbase.ui.login=?
-Dbase.ui.password=?

Внимание!
Вместо знаков вопроса введите соответствующие значения, которые можно найти в тестовом задании.

Здесь вместо знаков вопроса введите логин, указанный в тестовом задании:
-Dbase.api.login=?     
-Dbase.api.password=?
