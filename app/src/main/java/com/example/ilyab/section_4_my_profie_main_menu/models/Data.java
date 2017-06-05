package com.example.ilyab.section_4_my_profie_main_menu.models;


import com.example.ilyab.section_4_my_profie_main_menu.R;

import java.util.ArrayList;

/**
 * Created by Max on 08.05.2017.
 */

public class Data {
//Категории
    Category category = new Category("Пресс №1");
    Category category1 = new Category("Руки №2");
    Category category2 = new Category("Спина №3");
    Category category3 = new Category("Грудь №4");
    Category category4 = new Category("Плечи №5");
    Category category5 = new Category("Ноги №6");
    Category category6 = new Category("Кардио №7");
    Category category7 = new Category("Растяжка №8");




    //Exercises
    Exercise exercise = new Exercise("Жим носками");
    Exercise exercise1 = new Exercise("Жим носками в тренажёре");
    Exercise exercise2 = new Exercise("Подьёмы на носки");
    Exercise exercise3 = new Exercise("Подьёмы на носки в тренажёре");
    Exercise exercise4 = new Exercise("Жим гантелей лёжа");
    Exercise exercise5 = new Exercise("Жим гантелей лёжа головой вниз");
    Exercise exercise6 = new Exercise("Жим гантелей лёжа на наклонной скамье");
    Exercise exercise7 = new Exercise("Жим штанги лёжа головой вниз");
    Exercise exercise8 = new Exercise("Сведение рук в тренажёре <бабочка>");
    Exercise exercise9 = new Exercise("Приседания со штангой");
    Exercise exercise10 = new Exercise("Приседания со штангой на груди");
    Exercise exercise11 = new Exercise("Разгибания ног в тренажёре сидя");


    DescriptionExercises exdesc1 = new DescriptionExercises("Упражнение относится к классу изолирующих с " +
            "типом силы “пуш” (от слова толкать). Ввиду того, что икры - маленькая мышечная группа, " +
            "при воздействии на нее (заполнении кровью) ее в буквальном смысле распирает, что сопровождается" +
            " для атлета появлением чувства сильного жжения. Изолированная работа не позволяет “растекаться”" +
            " нагрузке, и всю ее принимает на себя голень.");
    DescriptionExercises exdesc2 = new DescriptionExercises("\t\n" +
            "Вы здесь: Упражнения→ Ноги → Передняя поверхность бедра\n" +
            "Жим ногами в тренажёре под углом\n" +
            "Медали\n" +
            "статьи:\tВесь ТОП 50статья в\n" +
            "ТОП 50\tВсе статьи, где от 100 до 500 комментариевболее 100\n" +
            "комментов\tВсе статьи, где более 1 000 000 просмотровболее 1 млн\n" +
            "просмотров\n" +
            "Автор: Тимко Илья - владыка всея сайта и тренер тренажёрного зала\n" +
            "Размещено: 2012-05-29  1 246 400\n" +
            "Основные мышцы - четырехглавая мышца бедра и большая ягодичная\n" +
            "Дополнительные - внутренняя и задняя поверхность бедра\n" +
            "Сложность выполнения - средняя\n" +
            "Жим ногами в тренажёре под углом\n" +
            "Жим ногами в тренажёре под углом - видео\n" +
            "\n" +
            " \n" +
            "\n" +
            " \n" +
            "\n" +
            "Знаете ли вы:\n" +
            "Когда вы тренируетесь в паре с кем-то, то эффективность ваших тренировок вырастает на 25%. Это доказано экспериментально (Почему тренировки с партнёром более эффективные?). \n" +
            "Ещё совет →\n" +
            "Вес и количество повторений для новичков\n" +
            "\n" +
            "Для мужчин: 10 - 15 повторений по 10 - 20 кг. 2 - 3 подхода.\n" +
            "Для женщин: 10 - 15 повторений по 5 - 10 кг. 2 - 3 подхода.\n" +
            "Нагрузка по группам мышц\n" +
            "\n" +
            "Нагрузка указана по 10-ти бальной шкале (общая нагрузка суммируется)\n" +
            "Передняя часть бедра\t9 (высокая)\n" +
            "Ягодицы\t8 (высокая)\n" +
            "Внутренняя часть бедра\t5 (средняя)\n" +
            "Задняя часть бедра\t5 (средняя)\n" +
            "Наружная часть бедра\t2 (слабая)\n" +
            "Общая нагрузка / тип упражнения\t29 (высокая) / базовое глобальное\n" +
            "Ограничения при травмах/болезнях/болях\n" +
            "\n" +
            "Степень риска указана по 10-ти бальной шкале\n" +
            "Боль в коленях\t5 (можно попробовать)\n" +
            "Описание упражнения\n" +
            "\n" +
            "Обычно чем выше угол у этого тренажера, тем он тяжелее. Ноги лучше ставить ближе к верхнему краю платформы. В таком случае меньше вероятность, что вы будете отрывать таз от лавки. А это может травмировать вашу спину. Ширину постановки ног можно варьировать.\n" +
            "\n" +
            "Основные фишки\n" +
            "\n" +
            "1. Это упражнение отлично подойдёт тем, у кого проблемы со спиной. Так как здесь нет осевой нагрузки на позвоночник и спина выключена из работы.\n" +
            "\n" +
            "2. Чем шире поставите ноги и разведёте колени в стороны, тем больше нагрузка ляжет на внутреннюю часть бедра. Чем уже ноги и колени, тем больше будет работать четырёхглавая мышца (передняя поверхность бедра).\n" +
            "\n" +
            "3. Чем ниже будете опускать платформу, тем больше будут работать ягодицы. Однако не переусердствуйте. В нижней точке таз не должен отрываться от опоры. Можно травмировать поясницу.\n" +
            "\n" +
            "4. Как вариант можно жать одной ногой. Нога в таком случае ставится чуть в стороне от центра платформы. А нагрузка больше идёт на внутреннюю поверхность бедра. Но новичкам такой вариант не советую.\n" +
            "\n" +
            "5. Так же можно попробовать не выпрямлять ноги до конца. Так ваши мышцы сильнее и быстрее забьются.\n" +
            "\n" +
            "6. Чем выше на платформе вы поставите ноги, тем больше будут грузиться ягодицы. А чем ниже – бёдра.\n" +
            "\n" +
            "7. Вообще, это упражнение является базовым. Но не советую им заменять приседания со штангой. Это оправдано только в том случае, если в силу травм вы не можете приседать.");

DescriptionExercises exdesc3 = new DescriptionExercises("Станьте в тренажер для подъемов на носки и подставьте плечи под опорные валики.\n" +
        "Поставьте подушечки ступней на платформу так, чтобы пятки располагались за ее краем и могли свободно опускаться и подниматься по максимально возможной амплитуде. Носки кроссовок чуть разведены в стороны или параллельны.\n" +
        "Полностью выпрямите и торс. Пятки, таз и плечи находятся в одной вертикальной плоскости.\n" +
        "Разгибая голеностопный сустав, плавно опуститесь на пятках до тех пор, пока не почувствуете, что ахиллесовы сухожилия и икроножные мышцы максимально растянуты.\n" +
        "Сделайте глубокий вдох и, задерживая дыхание, напрягите икры и мощным движением поднимитесь на носках как можно выше.\n" +
        "В верхней точке остановитесь на 1-2 секунды и постарайтесь как можно сильнее напрячь икры.\n" +
        "Немного расслабьтесь и с выдохом плавно опуститесь вниз.");


    MainImages img1 = new MainImages(R.mipmap.exercise_3);
    MainImages img2 = new MainImages(R.mipmap.exercise_2);
    MainImages img4 = new MainImages(R.mipmap.exercise_1);
    ArrayCategory arrayCategory = new ArrayCategory();


//Description
    public void addDescription() {
        exercise1.setDescriptions(exdesc1);
        exercise2.setDescriptions(exdesc2);
        exercise3.setDescriptions(exdesc3);
    }
//Add Images in Row Icon Category Listview
public void addImageCategory(){

    category.addImageCategory(R.mipmap.exercise_1);
    category1.addImageCategory(R.mipmap.exercise_2);
    category2.addImageCategory(R.mipmap.exercise_3);
    category3.addImageCategory(R.mipmap.exercise_1);
    category4.addImageCategory(R.mipmap.exercise_2);
    category5.addImageCategory(R.mipmap.exercise_3);
    category6.addImageCategory(R.mipmap.ic_exercise_2_1);
    category7.addImageCategory(R.mipmap.ic_exercise_2_2);

}
    public void addImageExercise(){
        exercise.addImageExercise(R.mipmap.exercise_2);
        exercise1.addImageExercise(R.mipmap.exercise_3);
        exercise2.addImageExercise(R.mipmap.ic_exercise_2_2);
        exercise3.addImageExercise(R.mipmap.exercise_2);
        exercise4.addImageExercise(R.mipmap.ic_exercise_2_1);
        exercise5.addImageExercise(R.mipmap.exercise_image);

    }
    //Add Images in Card of Exercise
    public void addImages(){
        exercise1.addImage("Изображение 1", R.mipmap.exercise_image);
        exercise1.addImage("Изображение 2", R.mipmap.ic_launcher);
        exercise1.addImage("3", R.mipmap.exercise_3);
        exercise1.addImage("4", R.mipmap.exercise_4);
        exercise2.addImage("Руки вверх", R.mipmap.ic_exercise_2_1);
        exercise2.addImage("Руки вниз", R.mipmap.ic_exercise_2_2);
    }
//Add Exercise
    public void addExercise() {

        category.addExercise(exercise);
        category.addExercise(exercise1);
        category.addExercise(exercise2);
        category.addExercise(exercise3);
        category1.addExercise(exercise4);
        category1.addExercise(exercise5);
        category2.addExercise(exercise6);
        category2.addExercise(exercise7);
        category3.addExercise(exercise8);
        category4.addExercise(exercise9);
        category4.addExercise(exercise10);
        category5.addExercise(exercise11);
        category6.addExercise(exercise11);
        category7.addExercise(exercise11);
//Add Main Images

        ArrayList<Category> categories = new ArrayList<>();

        categories.add(category);
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        categories.add(category4);
        categories.add(category5);
        categories.add(category6);
        categories.add(category7);

        arrayCategory.setCategories(categories);
    }
    public ArrayCategory getArrayCategory() {
        return arrayCategory;
    }
}
