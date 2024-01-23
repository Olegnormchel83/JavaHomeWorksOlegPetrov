package HomeWorks.FinalHW;

import java.util.Objects;

public class Laptop {
    private String name;
    private String cpu;
    private String gpu;
    private int hddMemory;
    private int ram;
    private String os;
    private String color;

    public Laptop(String name, String cpu, String gpu, int hddMemory, int ram, String os, String color) {
        this.name = name;
        this.cpu = cpu;
        this.gpu = gpu;
        this.hddMemory = hddMemory;
        this.ram = ram;
        this.os = os;
        this.color = color;
    }
    public String GetName() {
        return name;
    }
    public void SetName(String name) {
        this.name = name;
    }
    public String GetCPU() {
        return cpu;
    }
    public void SetCPU(String cpu) {
        this.cpu = cpu;
    }
    public String GetGPU() {
        return gpu;
    }
    public void SetGPU(String gpu) {
        this.gpu = gpu;
    }
    public int GetHddMemory() {
        return hddMemory;
    }
    public void SetHddMemory(int hddMemory) {
        this.hddMemory = hddMemory;
    }
    public int GetRam() {
        return ram;
    }
    public void SetRam(int ram) {
        this.ram = ram;
    }
    public String GetOS() {
        return os;
    }
    public void SetOS(String os) {
        this.os = os;
    }
    public String GetColor() {
        return color;
    }
    public void SetColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("Модель: %s%n" +
                "Процессор: %s%n" +
                "Видеокарта: %s%n" +
                "Объем памяти: %d%n" +
                "Оперативная память: %d%n" +
                "Операционная система: %s%n" +
                "Цвет: %s%n",
                name, cpu, gpu, hddMemory, ram, os, color);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return hddMemory == laptop.hddMemory
                && ram == laptop.ram
                && Objects.equals(name, laptop.name)
                && Objects.equals(cpu, laptop.cpu)
                && Objects.equals(gpu, laptop.gpu)
                && Objects.equals(os, laptop.os)
                && Objects.equals(color, laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cpu, gpu, hddMemory, ram, os, color);
    }
}
