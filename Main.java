package functions;
public class Main {
    public static void main(String[] args) {
        System.out.println("Тестирование методов toString(), equals(), hashCode(), clone()\n");

        // создаем тестовые точки
        FunctionPoint[] points1 = {
                new FunctionPoint(0.0, 1.0),
                new FunctionPoint(1.0, 3.0),
                new FunctionPoint(2.0, 5.0)
        };

        FunctionPoint[] points2 = {
                new FunctionPoint(0.0, 1.0),
                new FunctionPoint(1.0, 3.0),
                new FunctionPoint(2.0, 5.0)
        };

        FunctionPoint[] points3 = {
                new FunctionPoint(0.0, 1.0),
                new FunctionPoint(1.0, 3.5), // отличается Y
                new FunctionPoint(2.0, 5.0)
        };

        // создаем функции
        ArrayTabulatedFunction arrayFunc1 = new ArrayTabulatedFunction(points1);
        ArrayTabulatedFunction arrayFunc2 = new ArrayTabulatedFunction(points2);
        ArrayTabulatedFunction arrayFunc3 = new ArrayTabulatedFunction(points3);

        LinkedListTabulatedFunction listFunc1 = new LinkedListTabulatedFunction(points1);
        LinkedListTabulatedFunction listFunc2 = new LinkedListTabulatedFunction(points2);
        LinkedListTabulatedFunction listFunc3 = new LinkedListTabulatedFunction(points3);

        // тестирование toString()
        System.out.println("1. Тестирование toString():");
        System.out.println("ArrayTabulatedFunction: " + arrayFunc1.toString());
        System.out.println("LinkedListTabulatedFunction: " + listFunc1.toString());
        System.out.println();

        // Тестирование equals()
        System.out.println("2. Тестирование equals():");

        // Сравнение одинаковых объектов одного класса
        System.out.println("arrayFunc1.equals(arrayFunc2): " + arrayFunc1.equals(arrayFunc2)); // true
        System.out.println("listFunc1.equals(listFunc2): " + listFunc1.equals(listFunc2)); // true

        // сравнение разных объектов одного класса
        System.out.println("arrayFunc1.equals(arrayFunc3): " + arrayFunc1.equals(arrayFunc3)); // false
        System.out.println("listFunc1.equals(listFunc3): " + listFunc1.equals(listFunc3)); // false

        // сравнение объектов разных классов с одинаковыми точками
        System.out.println("arrayFunc1.equals(listFunc1): " + arrayFunc1.equals(listFunc1)); // true
        System.out.println("listFunc1.equals(arrayFunc1): " + listFunc1.equals(arrayFunc1)); // true
        System.out.println();

        System.out.println("3. Тестирование hashCode():");
        System.out.println("arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
        System.out.println("arrayFunc2.hashCode(): " + arrayFunc2.hashCode());
        System.out.println("arrayFunc3.hashCode(): " + arrayFunc3.hashCode());
        System.out.println("listFunc1.hashCode(): " + listFunc1.hashCode());
        System.out.println("listFunc2.hashCode(): " + listFunc2.hashCode());
        System.out.println("listFunc3.hashCode(): " + listFunc3.hashCode());

        System.out.println("\nПроверка согласованности equals() и hashCode():");
        System.out.println("arrayFunc1.equals(arrayFunc2) && arrayFunc1.hashCode() == arrayFunc2.hashCode(): " +
                (arrayFunc1.equals(arrayFunc2) && arrayFunc1.hashCode() == arrayFunc2.hashCode()));


        System.out.println("\nИзменение объекта и хэш-кода:");
        System.out.println("До изменения - arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
        arrayFunc1.setPointY(1, 3.001); // незначительно меняем Y
        System.out.println("После изменения - arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
        System.out.println("arrayFunc1.equals(arrayFunc2) после изменения: " + arrayFunc1.equals(arrayFunc2));
        System.out.println();

        // тестирование clone()
        System.out.println("4. Тестирование clone() и глубокого клонирования:");

        // клонирование ArrayTabulatedFunction
        ArrayTabulatedFunction arrayClone = (ArrayTabulatedFunction) arrayFunc2.clone();
        System.out.println("arrayFunc2.equals(arrayClone): " + arrayFunc2.equals(arrayClone)); // true
        System.out.println("arrayFunc2 == arrayClone: " + (arrayFunc2 == arrayClone)); // false

        // проверка глубокого клонирования для Array
        System.out.println("\nПроверка глубокого клонирования (ArrayTabulatedFunction):");
        System.out.println("До изменения - arrayClone.getPointY(1): " + arrayClone.getPointY(1));
        arrayFunc2.setPointY(1, 10.0); // меняем оригинал
        System.out.println("После изменения оригинала - arrayClone.getPointY(1): " + arrayClone.getPointY(1));
        System.out.println("Клон не изменился: " + (arrayClone.getPointY(1) != 10.0));

        // клонирование LinkedListTabulatedFunction
        LinkedListTabulatedFunction listClone = (LinkedListTabulatedFunction) listFunc2.clone();
        System.out.println("\nlistFunc2.equals(listClone): " + listFunc2.equals(listClone)); // true
        System.out.println("listFunc2 == listClone: " + (listFunc2 == listClone)); // false

        // проверка глубокого клонирования для LinkedList
        System.out.println("\nПроверка глубокого клонирования (LinkedListTabulatedFunction):");
        System.out.println("До изменения - listClone.getPointY(1): " + listClone.getPointY(1));
        listFunc2.setPointY(1, 15.0); // меняем оригинал
        System.out.println("После изменения оригинала - listClone.getPointY(1): " + listClone.getPointY(1));
        System.out.println("Клон не изменился: " + (listClone.getPointY(1) != 15.0));
    }
}