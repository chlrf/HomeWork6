import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        final int NUMBER_OF_QUESTIONS = 3;
        //Вывод вопросов и ввод ответов
        String[] listOfQuestions = {
                "\nВопрос 1.\nНазовите столицу РФ:\n",
                "Вопрос 2.\nНазовите столицу Германии:\n",
                "Вопрос 3.\nНазовите столицу Франции:\n"
        };
        String[] variantsOfAnswers = {
                "\tА. Москва\n\tБ. Берлин\n\tВ. Лондон\n\tГ. Мадрид", // вопрос 1
                "\tА. Москва\n\tБ. Париж\n\tВ. Лондон\n\tГ. Мадрид\n\tД. Берлин", // вопрос 2
                "\tА. Лондон\n\tБ. Мадрид\n\tВ. Париж"}; // вопрос 3

        Scanner scan = new Scanner(System.in);
        String[] userAnswers= new String[NUMBER_OF_QUESTIONS];

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++){
            System.out.println(listOfQuestions[i] + variantsOfAnswers[i]);
            System.out.print("Введите ответ (А, Б, В ...): ");
            userAnswers[i] = scan.next();
            System.out.println();
        }

        //Подсчет количества правильных ответов и сбор неправильных ответов в отдельный массив
        int numberOfRightAnswers = 0;
        String[] rightAnswers = {"А", "Д", "В"};
        String[] rightAnswersLowRegister = {"а", "д", "в"};
        String[] incorrectUserAnswers = new String[NUMBER_OF_QUESTIONS];
        for (int i = 0; i < 3; i++){
            if (userAnswers[i].equals(rightAnswers[i]) || userAnswers[i].equals(rightAnswersLowRegister[i])){
                numberOfRightAnswers++;
            }
            else{
                incorrectUserAnswers[i] = userAnswers[i];
            }
        }

        //Вывод кол-ва правильных ответов
        System.out.println("Ваш результат: \nПравильных ответов - " + numberOfRightAnswers + " из 3");
        //Вывод неправильных ответов и результата сдал/не сдал
        if (numberOfRightAnswers<NUMBER_OF_QUESTIONS){
            System.out.println("ТЕСТ НЕ СДАН");
            System.out.println("\tНеправильные ответы:");
            for (int i = 0; i < 3; i++){
                if (incorrectUserAnswers[i] != null)
                System.out.println("\tВопрос " + (i+1) + ": ваш ответ - " + incorrectUserAnswers[i] + " (верный ответ - " + rightAnswers[i] + ")");
            }
        }
        else {
            System.out.println("ТЕСТ СДАН!");
        };
    }
}
