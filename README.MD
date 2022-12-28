TreeEntity to TreDTO mapper
=


Мне нужно было реализовать метод:
````
Collection<TreeDTO> convert(Collection<TreeEntity> entities)
````
и покрыть его тестами.

<br><br>

Основная логика содержится в классе **TreeMapper** .
<br><br>
Класс **Main** использовался для отладки. Решил его не удалять, вдруг полезным
будет.
<br><br>
У меня в результирующей коллекции **Collection TreeDTO** после применения метода
содержатся корневые узлы деревьев.
<br><br>
Тесты написаны в классе **TreeMapperTest**.
Примеры таких деревьев я использовал в тесте:
<br><br>
тут у first был индекс родителя, а самого родителя не было. Аналогично с hasFiveKids. У оставшихся трех узлов (singleNode) вообще не был указан родитель.
![trees](https://github.com/kstrinadka/TreeMapper/blob/master/src/main/resources/testData.png)
Эти данные использовались в тестах
