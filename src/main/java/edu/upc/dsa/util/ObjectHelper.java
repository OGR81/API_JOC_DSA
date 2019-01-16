package edu.upc.dsa.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {
    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }


    public static void setter(Object object, String property, Object value)
            throws InvocationTargetException, IllegalAccessException{
        // Method // invoke

        Class theClass = object.getClass();
        Method[] methods = theClass.getMethods();

        for(Method method : methods){
            if(isSetter(method)){
                if(method.getName().toLowerCase().startsWith(property.toLowerCase(), 3)) {
                    method.invoke(object, value);
                    break;
                }
            }
        }
    }

    public static Object getter(Object object, String property) throws InvocationTargetException, IllegalAccessException {
        // Method // invoke

        Object result = null;
        Class theClass = object.getClass();
        Method[] methods = theClass.getMethods();

        for(Method method : methods){
            if(isGetter(method)){
                if(method.getName().toLowerCase().startsWith(property.toLowerCase(), 3))
                    result = (Object) method.invoke(object);
            }
        }

        return result;
    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }
    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }
}
