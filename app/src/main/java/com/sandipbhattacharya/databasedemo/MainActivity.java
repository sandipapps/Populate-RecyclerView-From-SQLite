package com.sandipbhattacharya.databasedemo;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DatabaseAdapter databaseAdapter;
    RecyclerView rvPrograms;
    ContactsAdapter contactsAdapter;
    RecyclerView.LayoutManager layoutManager;
    List<Contacts> contactsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PreCreateDB.copyDB(this);
        databaseAdapter = new DatabaseAdapter(this);
        contactsList = databaseAdapter.getAllContacts();
        rvPrograms = findViewById(R.id.rvPrograms);
        rvPrograms.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvPrograms.setLayoutManager(layoutManager);
        contactsAdapter = new ContactsAdapter(this, contactsList, rvPrograms);
        rvPrograms.setAdapter(contactsAdapter);
    }
}
