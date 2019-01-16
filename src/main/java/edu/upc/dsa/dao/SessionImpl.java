package edu.upc.dsa.dao;

import edu.upc.dsa.util.ObjectHelper;
import edu.upc.dsa.util.QueryHelper;

import javax.management.Query;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SessionImpl implements Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);

        // INSERT INTO User (ID, , surname, salary) VALUES (?, ?, ?, ?)

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            pstm.setObject(1,0);

            String[] fields = ObjectHelper.getFields(entity);
            for (int i = 1; i < fields.length; i++) {
                pstm.setObject(i+1, ObjectHelper.getter(entity, fields[i]));
            }

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object get(Class theClass, int ID) {

        try {

            String selectQuery = QueryHelper.createQuerySELECT(theClass.newInstance());

            PreparedStatement pstm;
            ResultSet rs;

            Object entity = theClass.newInstance();

            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, ID);

            rs = pstm.executeQuery();

            if (rs.next()) {
                Field[] fields = theClass.getDeclaredFields();
                for (int i = 0; i<fields.length; i++){
                    ObjectHelper.setter(entity, fields[i].getName(), rs.getObject(i + 1));
                }

                return entity;
            } else {
                return null;
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void update(Object object, int ID) {
        String updateQuery = QueryHelper.createQueryUPDATE(object);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(updateQuery);
            int i = 1;

            for(String field: ObjectHelper.getFields(object)){
                pstm.setObject(i++, ObjectHelper.getter(object, field));
            }

            pstm.setObject(i,ID);

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void delete(Object object, int ID) {
        String deleteQuery = QueryHelper.createQueryDELETE(object);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(deleteQuery);
            pstm.setObject(1, ID);

            pstm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Object> findAll(Class theClass) {
        return findAll(theClass, null);
    }

    /*
     *          HashMap params = new HashMap();
     *          params.put("mail", new Condition("=", "ddddddd");
     *          session.findAll(User.class, params);
     *
     *          SELECT * FROM User WHERE ( edat = 15 AND salary>=10000)
     */
    public List<Object> findAll(Class theClass, HashMap params) {

        String findAllQuery = QueryHelper.findAllQuery(theClass, params);

        Object entity = null;
        List<Object> listOfObjects = new ArrayList<>();

        try {
            entity = theClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ResultSet rs = null;
        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(findAllQuery);
            rs = pstm.executeQuery();

            while(rs.next()){
                Field[] fields = theClass.getDeclaredFields();
                for (int i = 0; i<fields.length; i++){
                    ObjectHelper.setter(entity, fields[i].getName(), rs.getObject(i + 1));
                }

                listOfObjects.add(entity);

                entity = theClass.newInstance();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return listOfObjects;
    }

    /*
     *          HashMap params = new HashMap();
     *          params.put("mail", new Condition("=", "ddddddd");
     *
     *          User user = (User)session.findOne(User.class, params);
     *          user.getPassword().equals(password)
     *          Select * from User WHERE mail = '"+ mail +"'"
     */
    public Object findOne(Class theClass, HashMap params) {

        List<Object> result = findAll(theClass, params);

        if (!result.isEmpty()) {
            return result.get(0);
        } else {
            return null;
        }
    }

    /*
     *          SELECT * FROM User, Deparment  WHERE ( edat = 15 AND salary>=10000)
     */
    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }

    @Override
    public int count(Class theClass) {
        String selectQuery = QueryHelper.createQueryCount(theClass);

        PreparedStatement pstm = null;
        ResultSet result = null;
        int val = 0;

        try {
            pstm = conn.prepareStatement(selectQuery);
            result = pstm.executeQuery();

            if (result.next()) {
                val = result.getInt (1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return val;
    }


}
