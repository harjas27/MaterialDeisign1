package harjas.com.task;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private RecyclerAdapter mAdapter;
    private Context context;
    private String[] drawerListViewItems;
    private ListView drawerListView;
    private ArrayList<GetterSetter> feedItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerListViewItems = getResources().getStringArray(R.array.items);

        // get ListView defined in activity_main.xml
        drawerListView = (ListView) findViewById(R.id.left_drawer);

        // Set the adapter for the list view
        drawerListView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_listview_item, drawerListViewItems));

        //find recyclerview layout
        mRecyclerView = (RecyclerView) findViewById(R.id.rv);
        mRecyclerView.setHasFixedSize(true);

        // recyclerview set layoutmanager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //adding data to arraylist
        feedItemList = new ArrayList<GetterSetter>();
        for (int i = 0; i < 20; i++) {
            GetterSetter getterSetter = new GetterSetter();
            feedItemList.add(getterSetter);
        }

        //recyclerview adapter
        mAdapter = new RecyclerAdapter(MainActivity.this, feedItemList);

        //set adpater for recyclerview
        mRecyclerView.setAdapter(mAdapter);


    }

}