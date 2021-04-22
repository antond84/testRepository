import java.util.Random;
import java.util.Scanner;

public class n4 {

        public static char[][] map;
        public static int mapX;
        public static int mapY;

        public static char playerDot = 'X';
        public static char computerDot = 'O';
        public static char emptyDot = '_';

        public static Scanner scanner = new Scanner(System.in);
        public static Random random = new Random(); //[0 -> 1)

        public static void main(String[] args) {
            makeMap();
            showMap();

            while (true) {
                PlayerGo();
                showMap();
                if (checkWin(playerDot)) {
                    System.out.println("Игрок побеждает");
                    break;
                }
                if (isFullMap()) {
                    System.out.println("Ничья");
                    break;
                }

                ComputerGo();
                showMap();
                if (checkWin(computerDot)) {
                    System.out.println("Компьютер побеждает");
                    break;
                }
                if (isFullMap()) {
                    System.out.println("Ничья");
                    break;
                }
            }
        }

        public static void makeMap() { // Создание карты 3х3
            mapX = 3;
            mapY = 3;
            map = new char[mapY][mapX];

            for (int y = 0; y < mapY; y++) {
                for (int x = 0; x < mapX; x++) {
                    map[y][x] = emptyDot;
                }
            }
        }

        public static void showMap() { // Вывод поля в консоль
            System.out.println("-----------------");
            for (int y = 0; y < mapY; y++) {
                for (int x = 0; x < mapX; x++) {
                    System.out.print(map[y][x] + "|");
                }
                System.out.println();
            }
            System.out.println("-----------------");
        }

        public static void PlayerGo() { // Ход игрока

            int x;
            int y;

            do {
                System.out.println("Введите координаты: ");
                x = scanner.nextInt() - 1;
                y = scanner.nextInt() - 1;
            } while (!validField(y, x) || !emptyField(y, x));

            map[y][x] = playerDot;

        }
        public static void ComputerGo() { // Ход компьютера

            int x;
            int y;

            do {
                x = random.nextInt(mapX); //(0-2)
                y = random.nextInt(mapY); //(0-2)
            } while (!emptyField(y, x));

            map[y][x] = computerDot;

        }
        public static boolean emptyField(int y, int x) { // Проверка пустая ли клетка
            return map[y][x] == emptyDot;
        }

        public static boolean validField(int y, int x) { // Проверка верных координат
            return x >= 0 && x < mapX && y >= 0 && y < mapY;
        }
        public static boolean checkWin(char currentPlayer){
            if (map[0][0] == currentPlayer && map[0][1] == currentPlayer && map[0][2] == currentPlayer) return true;
            if (map[1][0] == currentPlayer && map[1][1] == currentPlayer && map[1][2] == currentPlayer) return true;
            if (map[2][0] == currentPlayer && map[2][1] == currentPlayer && map[2][2] == currentPlayer) return true;

            if (map[0][0] == currentPlayer && map[1][0] == currentPlayer && map[2][0] == currentPlayer) return true;
            if (map[0][1] == currentPlayer && map[1][1] == currentPlayer && map[2][1] == currentPlayer) return true;
            if (map[0][2] == currentPlayer && map[1][2] == currentPlayer && map[2][2] == currentPlayer) return true;

            if (map[0][0] == currentPlayer && map[1][1] == currentPlayer && map[2][2] == currentPlayer) return true;
            if (map[0][2] == currentPlayer && map[1][1] == currentPlayer && map[2][0] == currentPlayer) return true;

            return false;
        }
        public static boolean isFullMap() {
            for (int y = 0; y < mapY; y++) {
                for (int x = 0; x < mapX; x++) {
                    if (map[y][x] == emptyDot) {
                        return false;
                    }
                }
            }
            return true;
        }
    }


