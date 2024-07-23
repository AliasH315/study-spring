package ru.itone.iismagilov.study.spring.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ru.itone.iismagilov.study.spring.dao.StudentDao;
import ru.itone.iismagilov.study.spring.dao.entity.StudentEntity;

import java.sql.Types;
import java.util.List;
import java.util.Map;

public class StudentDaoInDBImpl implements StudentDao {
    //language=postgresql
    private static final String SQL_SELECT_STUDENT_ENTITY = """
            select  id,
                    name,
                    lastname,
                    middlename,
                    address,
                    age,
                    passport
            from tstudent
            where id = :id
            """;
    private static final String SQL_UPDATE_STUDENT_ENTITY = """
            update tstudent
            set     name = :name,
                    lastname = :lastname,
                    middlename = :middlename,
                    address = :address,
                    age = :age,
                    passport = :passport
            where id = :id
            """;

    private static final String SQL_INSERT_STUDENT_ENTITY = """
            insert into tstudent (name,lastname,middlename,address,age,passport)
            values(:name,:lastname,:middlename,:address,:age,:passport)
            """;

    private static final String SQL_DELETE_STUDENT_ENTITY = """
            delete from tstudent
            where id = :id
            """;

    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_LASTNAME = "lastname";
    private static final String FIELD_MIDDLENAME = "middlename";
    private static final String FIELD_ADDRESS = "address";
    private static final String FIELD_AGE = "age";
    private static final String FIELD_PASSPORT = "passport";

    private final NamedParameterJdbcTemplate namedJdbcTemplate;


    public StudentDaoInDBImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public StudentEntity save(StudentEntity studentEntity) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedJdbcTemplate.update(SQL_INSERT_STUDENT_ENTITY,
                new MapSqlParameterSource().addValue(FIELD_NAME, studentEntity.getName(), Types.VARCHAR)
                        .addValue(FIELD_LASTNAME, studentEntity.getLastName(), Types.VARCHAR)
                        .addValue(FIELD_MIDDLENAME, studentEntity.getMiddleName(), Types.VARCHAR)
                        .addValue(FIELD_PASSPORT, studentEntity.getPassport(), Types.VARCHAR)
                        .addValue(FIELD_AGE, studentEntity.getAge(), Types.INTEGER)
                        .addValue(FIELD_ADDRESS, studentEntity.getAddress(), Types.VARCHAR),
                generatedKeyHolder);
        Map<String, Object> keys = generatedKeyHolder.getKeys();

        StudentEntity student = new StudentEntity();

        if (keys != null) {
            Object keysID = keys.get(FIELD_ID);
            if (keysID != null) {
                student.setId((Integer) keys.get(FIELD_ID));
            }
            Object keysName = keys.get(FIELD_NAME);
            if (keysName != null) {
                student.setName((String) keys.get(FIELD_NAME));
            }
            Object keysLastName = keys.get(FIELD_LASTNAME);
            if (keysLastName != null) {
                student.setLastName((String) keys.get(FIELD_LASTNAME));
            }
            Object keysMiddleName = keys.get(FIELD_MIDDLENAME);
            if (keysMiddleName != null) {
                student.setMiddleName((String) keys.get(FIELD_MIDDLENAME));
            }
            Object keysPassport = keys.get(FIELD_PASSPORT);
            if (keysPassport != null) {
                student.setPassport((String) keys.get(FIELD_PASSPORT));
            }
            Object keysAge = keys.get(FIELD_AGE);
            if (keysAge != null) {
                student.setAge((Integer) keys.get(FIELD_AGE));
            }
            Object keysAddress = keys.get(FIELD_ADDRESS);
            if (keysAge != null) {
                student.setAddress((String) keys.get(FIELD_ADDRESS));
            }
        }


        return student;
    }

    @Override
    public StudentEntity find(int id) {

        List<StudentEntity> studentList = namedJdbcTemplate.query(SQL_SELECT_STUDENT_ENTITY, new MapSqlParameterSource().addValue(FIELD_ID, id, Types.INTEGER),
                (resultSet, rowNum) -> {
                    StudentEntity studentEntity = new StudentEntity();
                    studentEntity.setId(resultSet.getInt(FIELD_ID));
                    studentEntity.setName(resultSet.getString(FIELD_NAME));
                    studentEntity.setLastName(resultSet.getString(FIELD_LASTNAME));
                    studentEntity.setMiddleName(resultSet.getString(FIELD_MIDDLENAME));
                    studentEntity.setAge(resultSet.getInt(FIELD_AGE));
                    studentEntity.setPassport(resultSet.getString(FIELD_PASSPORT));
                    studentEntity.setAddress(resultSet.getString(FIELD_ADDRESS));
                    return studentEntity;
                });

        if (studentList.isEmpty()) {
            return null;
        } else if (studentList.size() > 1) {
            throw new RuntimeException("По id=" + id + " найдено более 1 записи: " + studentList.size());
        } else {
            return studentList.get(0);
        }
    }

    @Override
    public StudentEntity update(StudentEntity studentEntity) {
        return null;
    }

    @Override
    public StudentEntity delete(int id) {
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        namedJdbcTemplate.update(SQL_DELETE_STUDENT_ENTITY, new MapSqlParameterSource().addValue(FIELD_ID, id, Types.INTEGER),
                generatedKeyHolder);
        Map<String, Object> keys = generatedKeyHolder.getKeys();
        StudentEntity studentEntity = new StudentEntity();

        if (keys != null) {
            Object keysID = keys.get(FIELD_ID);
            if (keysID != null) {
                studentEntity.setId((Integer) keys.get(FIELD_ID));
            }
            Object keysName = keys.get(FIELD_NAME);
            if (keysName != null) {
                studentEntity.setName((String) keys.get(FIELD_NAME));
            }
            Object keysLastName = keys.get(FIELD_LASTNAME);
            if (keysLastName != null) {
                studentEntity.setLastName((String) keys.get(FIELD_LASTNAME));
            }
            Object keysMiddleName = keys.get(FIELD_MIDDLENAME);
            if (keysMiddleName != null) {
                studentEntity.setMiddleName((String) keys.get(FIELD_MIDDLENAME));
            }
            Object keysPassport = keys.get(FIELD_PASSPORT);
            if (keysPassport != null) {
                studentEntity.setPassport((String) keys.get(FIELD_PASSPORT));
            }
            Object keysAge = keys.get(FIELD_AGE);
            if (keysAge != null) {
                studentEntity.setAge((Integer) keys.get(FIELD_AGE));
            }
            Object keysAddress = keys.get(FIELD_ADDRESS);
            if (keysAge != null) {
                studentEntity.setAddress((String) keys.get(FIELD_ADDRESS));
            }
        }
        return studentEntity;
    }
}
