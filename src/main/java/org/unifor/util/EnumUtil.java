package org.unifor.util;

import java.lang.reflect.Field;

public class EnumUtil {

    public static <E extends Enum<E>> E getEnumByField(Class<E> enumClass, String fieldName, Object value) {
        E[] constants = enumClass.getEnumConstants();

        for (E constant : constants) {
            try {
                Field field = enumClass.getDeclaredField(fieldName);
                field.setAccessible(true);

                if (field.get(constant).equals(value)) {
                    return constant;
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new IllegalArgumentException("Erro ao acessar o campo: " + fieldName);
            }
        }

        return null;
    }


}
