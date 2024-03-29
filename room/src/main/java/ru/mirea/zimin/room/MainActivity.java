package ru.mirea.zimin.room;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String TAG = ru.mirea.zimin.room.MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ru.mirea.zimin.room.AppDatabase db = ru.mirea.zimin.room.App.getInstance().getDatabase();
        ru.mirea.zimin.room.EmployeeDao employeeDao = db.employeeDao();
        ru.mirea.zimin.room.Employee employee = new ru.mirea.zimin.room.Employee();
        employee.id = 1;
        employee.name = "John Smith";
        employee.salary = 10000;
// запись сотрудников в базу
        employeeDao.insert(employee);
// Загрузка всех работников
        List<ru.mirea.zimin.room.Employee> employees = employeeDao.getAll();
// Получение определенного работника с id = 1
        employee = employeeDao.getById(1);
// Обновление полей объекта
        employee.salary = 20000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.salary);
    }
}