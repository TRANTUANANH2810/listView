package com.example.listview_ltdtdd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    Khai bao mảng
    ListView lvMonHoc;
    ArrayList<String> arrayCourse;
    Button btnThem, btnCapNhat;
    EditText edtMonhoc;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// ánh xạ
        lvMonHoc = (ListView) findViewById(R.id.listviewMonHoc);
        btnThem = (Button) findViewById(R.id.btnThem);
        edtMonhoc = (EditText) findViewById(R.id.edittextMonhoc);
        btnCapNhat = (Button) findViewById(R.id.btnCapNhat);
        arrayCourse = new ArrayList<>();

        arrayCourse.add("Androind");
        arrayCourse.add("WEb Nâng cao");
        arrayCourse.add("LT hướng đối tượng");
        arrayCourse.add("Game");
        arrayCourse.add("JAva");
        arrayCourse.add("Adobe");

        ArrayAdapter adapter = new ArrayAdapter(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                arrayCourse
        );

        lvMonHoc.setAdapter(adapter);

//         bắt sự kiện khi click vào btnThem
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String monhoc = edtMonhoc.getText().toString();
                arrayCourse.add(monhoc);
//                 cập nhật lại dl
                adapter.notifyDataSetChanged();
                edtMonhoc.setText("");
            }
        });

//        băt sự kiện khi click vào btnCapnhat
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtMonhoc.setText(arrayCourse.get(i));
                vitri = i;
            }
        });
        btnCapNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayCourse.set(vitri,edtMonhoc.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

//        băt sự kiện xóa
        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                arrayCourse.remove(i);
                adapter.notifyDataSetChanged();

                return false;
            }
        });

//        cham vaof bawts suwj kieenj liền
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                trar veef vij tris nguwoif dungf ddang click treen lisst view
                Toast.makeText(MainActivity.this, arrayCourse.get(i) , Toast.LENGTH_SHORT).show();

            }
        });

        lvMonHoc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Màn hình chi tiết" + i, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}