package it.sevenbits.calculator;

public interface Operation {
    float apply(float left, float right);
    String getName();
}
