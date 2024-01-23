package HomeWorks.FinalHW;

import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    public static void main(String[] args) {
        Laptop lenovoLegion = new Laptop("Lenovo Legion 7 Gen 7",
                                        "Core i7-12800HX",
                                        "GeForce RTX3070Ti",
                                        1024,
                                        32,
                                        "Windows 11",
                                        "Grey");
        Laptop msiStealth = new Laptop("MSI Stealth GS77",
                                        "Core i9 12900H",
                                        "GeForce RTX3070Ti",
                                        1024,
                                        32,
                                        "Windows 11",
                                        "Black");
        Laptop gigabyte = new Laptop("Gigabyte G7 MF",
                                        "Core i5 12500H",
                                        "GeForce RTX4050",
                                        512,
                                        16,
                                        "Windows 11",
                                        "Black");
        Laptop acer = new Laptop("Acer Nitro 5AN515-58",
                                    "Core i5-12450H",
                                    "GeForce RTX3050",
                                    512,
                                    8,
                                    "Windows 11",
                                    "Red");
        Laptop asus = new Laptop("ASUS TUF Gaming F15",
                                    "Core i7 11800H",
                                    "GeForce RTX3050Ti",
                                    512,
                                    16,
                                    "Windows 11",
                                    "Blue");

        Set<Laptop> laptops = new HashSet<>(Arrays.asList(lenovoLegion, msiStealth, gigabyte, acer, asus));

        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }

        userRequest(laptops);
    }

    private static void userRequest(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите критерий ноутбука: ");
        System.out.println("1 - Название");
        System.out.println("2 - Процессор");
        System.out.println("3 - Видеокарта");
        System.out.println("4 - Объем HDD");
        System.out.println("5 - Объем ОЗУ");
        System.out.println("6 - ОС ");
        System.out.println("7 - Цвет ");

        int criteria = scanner.nextInt();
        scanner.nextLine();
        Map<String, Object> filterCriteria = new HashMap<>();

        switch(criteria) {
            case 1:
                System.out.println("Выберите модель ноутбука:");
                Set<String> allModels = GetAllModels(laptops);
                System.out.println("Все модели: " + allModels);
                String name = scanner.nextLine();
                filterCriteria.put("Название", name);
                break;
            case 2:
                System.out.println("Выберите процессор:");
                Set<String> allCPU = GetAllCPU(laptops);
                System.out.println("Все процессоры: " + allCPU);
                String cpu = scanner.nextLine();
                filterCriteria.put("Процессор", cpu);
                break;
            case 3:
                System.out.println("Выберите видеокарту:");
                Set<String> allGPU = GetAllGPU(laptops);
                System.out.println("Все видеокарты: " + allGPU);
                String gpu = scanner.nextLine();
                filterCriteria.put("Видеокарта", gpu);
                break;
            case 4:
                System.out.println("Выберите объем HDD:");
                Set<Integer> allHDD = GetAllHDD(laptops);
                System.out.println("Все HDD: " + allHDD);
                int hddMemoryMin = scanner.nextInt();
                filterCriteria.put("Объем HDD", hddMemoryMin);
                break;
            case 5:
                System.out.println("Выберите объем ОЗУ:");
                Set<Integer> allRam = GetAllRam(laptops);
                System.out.println("Все ОЗУ: " + allRam);
                int minRam = scanner.nextInt();
                filterCriteria.put("ОЗУ", minRam);
                break;
            case 6:
                System.out.println("Выберите ОС:");
                Set<String> allOS = GetAllOS(laptops);
                System.out.println("Все ОС: " + allOS);
                String os = scanner.nextLine();
                filterCriteria.put("ОС", os);
                break;
            case 7:
                System.out.println("Выберите цвет:");
                Set<String> allColors = GetAllColors(laptops);
                System.out.println("Все цвета: " + allColors);
                String color = scanner.nextLine();
                filterCriteria.put("Цвет", color);
                break;
            default:
                System.out.println("Некорректный критерий");
                return;
        }

        Set<Laptop> filteredLaptops = filterLaptops(laptops, filterCriteria);
        System.out.println("Отфильтрованнеые ноутбуки:");
        for (Laptop laptop : filteredLaptops) {
            System.out.println(laptop);
        }
    }

    private static Set<Laptop> filterLaptops(Set<Laptop> laptops, Map<String, Object> filterCriteria) {
        Set<Laptop> filteredLaptops = new HashSet<>(laptops);

        for (Laptop laptop : laptops) {
            for (Map.Entry<String, Object> entry : filterCriteria.entrySet()) {
                String criteria = entry.getKey();
                Object value = entry.getValue();

                switch (criteria) {
                    case "Название":
                        if (!laptop.GetName().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "Процессор":
                        if (!laptop.GetCPU().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "Видеокарта":
                        if (!laptop.GetGPU().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "Объем HDD":
                        if (laptop.GetHddMemory() < (int) value) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "ОЗУ":
                        if (laptop.GetRam() < (int) value) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "ОС":
                        if (!laptop.GetOS().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                    case "Цвет":
                        if (!laptop.GetColor().equals(value)) {
                            filteredLaptops.remove(laptop);
                        }
                        break;
                }
            }
        }
        return filteredLaptops;
    }

    private static Set<String> GetAllModels(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::GetName)
                .collect(Collectors.toSet());
    }

    private static Set<String> GetAllCPU(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::GetCPU)
                .collect(Collectors.toSet());
    }

    private static Set<String> GetAllGPU(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::GetGPU)
                .collect(Collectors.toSet());
    }

    private static Set<Integer> GetAllHDD(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::GetHddMemory)
                .collect(Collectors.toSet());
    }

    private static Set<Integer> GetAllRam(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::GetRam)
                .collect(Collectors.toSet());
    }

    private static Set<String> GetAllOS(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::GetOS)
                .collect(Collectors.toSet());
    }

    private static Set<String> GetAllColors(Set<Laptop> laptops) {
        return laptops.stream()
                .map(Laptop::GetColor)
                .collect(Collectors.toSet());
    }
}
