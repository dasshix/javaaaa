// Практика: Вложенный класс в интерфейсе
interface Shape {
    void draw();

    // Вложенный класс (автоматически static)
    class DefaultShape implements Shape {
        @Override
        public void draw() {
            System.out.println("Рисуем фигуру по умолчанию");
        }

        public void showInfo() {
            System.out.println("Это вложенный класс в интерфейсе");
        }
    }
}

public class NestedInInterfaceDemo {
    public static void main(String[] args) {
        // Создание экземпляра вложенного класса
        Shape.DefaultShape shape = new Shape.DefaultShape();

        // Вызов методов
        shape.draw();      // Метод из интерфейса
        shape.showInfo();  // Собственный метод класса
    }
}