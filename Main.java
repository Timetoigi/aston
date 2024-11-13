//Задание 1
class Animal {
    protected static int count = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " м.");
    }
}

class Dog extends Animal {
    private static int dogCount = 0;

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать более 500 м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println(name + " не может проплыть более 10 м.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}

class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println(name + " не может пробежать более 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() > 0) {
            System.out.println(name + " кушает.");
            isFull = bowl.eat();
        } else {
            System.out.println(name + " не ест, в миске недостаточно еды.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public boolean eat() {
        int foodNeeded = 5;
        if (foodAmount >= foodNeeded) {
            foodAmount -= foodNeeded;
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Всего еды: " + foodAmount);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        dogBobik.run(150);
        dogBobik.swim(5);

        Cat catMurzik = new Cat("Мурзик");
        catMurzik.run(100);
        catMurzik.swim(10);

        Bowl bowl = new Bowl(10);
        Cat[] cats = {new Cat("Кот 1"), new Cat("Кот 2"), new Cat("Кот 3")};

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        for (Cat cat : cats) {
            System.out.println(cat.name + " сытость: " + cat.isFull());
        }

        bowl.addFood(15);
        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        System.out.println("Всего животных: " + Animal.getCount());
        System.out.println("Всего собак: " + Dog.getDogCount());
        System.out.println("Всего котов: " + Cat.getCatCount());
    }
}


//Задание 2
interface Shape {
    double calculateArea();
    double calculatePerimeter();
    String getFillColor();
    String getBorderColor();

    default void printDetails() {
        System.out.println("Периметр: " + calculatePerimeter() + ", Площадь: " + calculateArea() +
                ", Цвет заливки: " + getFillColor() + ", Цвет границ: " + getBorderColor());
    }
}

class Circle implements Shape {
    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements Shape {
    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Shape {
    private double sideA;
    private double sideB;
    private double sideC;
    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double calculateArea() {
        // Используем формулу Герона для расчета площади
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Красный", "Чёрный");
        Shape rectangle = new Rectangle(4, 6, "Зелёный", "Синий");
        Shape triangle = new Triangle(3, 4, 5, "Жёлтый", "Фиолетовый");

        System.out.println("Характеристики круга:");
        circle.printDetails();

        System.out.println("\nХарактеристики прямоугольника:");
        rectangle.printDetails();

        System.out.println("\nХарактеристики треугольника:");
        triangle.printDetails();
    }
}
