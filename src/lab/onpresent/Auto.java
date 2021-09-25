package lab.onpresent;

public class Auto {

    public static void main(String[] args) {

        // Создать Авто
        Auto auto = new Auto();
        auto.printAutoStatus();

        // Запустить двигатель
        auto.engineStart();
        auto.printAutoStatus();

        // Увеличиваем скорость
        auto.pressPedalGas();
        auto.printAutoStatus();

        // Увеличиваем скорость
        auto.pressPedalGas();
        auto.printAutoStatus();

        // Включаем поддержание заданной скорости
        auto.cruiseControlOn();
        auto.printAutoStatus();

        // Увеличиваем скорость
        auto.pressPedalGas();
        auto.printAutoStatus();

        // Выключаем поддержание заданной скорости
        auto.cruiseControlOff();
        auto.printAutoStatus();

        // Увеличиваем скорость
        auto.pressPedalGas();
        auto.printAutoStatus();

        // Глушим двигатель
        auto.engineOff();
        auto.printAutoStatus();

    }

    private int speed;
    private int speedStep = 10;
    private boolean engineState;
    private boolean cruiseControl;


    private String stateTranslater(boolean name) {
        String tranclateName = "Включен";
        if (name == false) {
            tranclateName = "Выключен";
        }
        return tranclateName;
    }

    private void setEngineState(boolean setEngineState) {
        this.engineState = setEngineState;
    }

    private boolean isEngineState() {
        return engineState;
    }

    private boolean isCruiseControl() {
        return cruiseControl;
    }

    private void setSpeed(float speed) {
        this.speed += speed;
    }

    private float getSpeed() {
        return speed;
    }

    private void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }


    // конструктор Создать авто
    public Auto() {
        System.out.println("->Создаем новое Авто<-");
        speed = 0;
        setEngineState(false);
        setCruiseControl(false);
    }

    // Завести
    public void engineStart() {
        if (isEngineState() == false) {
            setEngineState(true);
            System.out.println("->Заводим двигатель<-");
        } else {
            System.out.println("Ошибка: Двигатель уже заведен!");
        }
    }

    // Заглушити авто
    public void engineOff() {
        System.out.println("->Глушим двигатель<-");
        if (isEngineState() == true) {
            while (getSpeed() > 0) {
                setSpeed(-speedStep);
                System.out.println("Скорость: " + speed);
            }
            setEngineState(false);
            setCruiseControl(false);
        } else {
            System.out.println("Ошибка: Двигатель уже выключен!");
        }
    }

    // Ехать, добавляем скорость
    public void pressPedalGas() {
        System.out.println("->Пробуем увеличить скорость<-");
        if (cruiseControl == true) {
            System.out.println("Изменение скорости заблокировно. Выключите Сruise Control!");
        } else {
            // Добавляем +10 к текущей скорости
            if (isEngineState() == true) {
                System.out.println("->Автомобиль едет<-");
                setSpeed(10);
            } else {
                System.out.println("Ошибка: Двигатель уже выключен!");
            }
        }
    }

    public void cruiseControlOn() {
        System.out.println("->Включаем Сruise Control!<-");
        setCruiseControl(true);
    }

    public void cruiseControlOff() {
        System.out.println("->Выключаем Сruise Control!<-");
        setCruiseControl(false);
    }

    public void printAutoStatus() {
        System.out.println(
                "Статус Авто:\nДвигатель: " + stateTranslater(isEngineState()) +
                        "\nСruise Control: " + stateTranslater(isCruiseControl()) +
                        "\nСкорость: " + speed +
                        "\n---------------------"
        );
    }

}