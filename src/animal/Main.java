package animal;

import animal.entity.Animal;

import java.util.List;

/**
 * Создать новую базу данных с помощью MySQLWorkbench.
 * Создать обычный java-проект и подключить к нему библиотеки JPA и Hibernate.
 * Создать файл с настройками persistence.xml в папке META-INF.
 * Создать класс Animal(int age, String name, boolean tail) с методами get и set, как сущность к нашей таблице.
 * С помощью jpa сделать crud в классе AnimalHelper.
 */

public class Main {
    public static void main(String[] args) {
        AnimalHelper ah = new AnimalHelper();

        // add animals
        Animal cat = new Animal();
        cat.setAge(2);
        cat.setTail(true);
        cat.setName("Kli");
        ah.addAnimal(cat);

        cat.setAge(3);
        cat.setTail(true);
        cat.setName("Venti");
        ah.addAnimal(cat);

        cat.setAge(1);
        cat.setTail(true);
        cat.setName("Diluc");
        ah.addAnimal(cat);

        // delete animal by id
        ah.removeAnimal(ah.getById(1));

        // update animal's name, age, tail
        ah.update(2, "Jane");
        ah.update(2, false);
        ah.update(2, 10);

        // print list of animals
        List<Animal> list = ah.getAnimalList();
        for (Animal temp : list) {
            System.out.println(temp.getId() + " " + temp.getName() + " " + temp.getAge() + " " + temp.isTail());
       }






    }
}
