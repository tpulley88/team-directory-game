package com.example.teamdirectory.view;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamdirectory.R;
import com.example.teamdirectory.adapter.MemberAdapter;
import com.example.teamdirectory.model.TeamMember;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PracticeActivity extends AppCompatActivity {
    private final Random random = new Random();
    private final List<TeamMember> members = new ArrayList<>(Arrays.asList(
            new TeamMember("Avery Chen", Color.rgb(70, 130, 180)),
            new TeamMember("Jordan Brooks", Color.rgb(218, 112, 91)),
            new TeamMember("Morgan Diaz", Color.rgb(95, 158, 160)),
            new TeamMember("Riley Patel", Color.rgb(147, 112, 219)),
            new TeamMember("Casey Thompson", Color.rgb(205, 133, 63)),
            new TeamMember("Taylor Kim", Color.rgb(60, 179, 113))
    ));

    private TextView prompt;
    private TeamMember target;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        prompt = findViewById(R.id.lookupName);
        RecyclerView recyclerView = findViewById(R.id.treeRV);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        Collections.shuffle(members);
        recyclerView.setAdapter(new MemberAdapter(members, this::checkAnswer));
        chooseTarget();
    }

    private void chooseTarget() {
        target = members.get(random.nextInt(members.size()));
        prompt.setText(getString(R.string.find_member, target.getName()));
    }

    private void checkAnswer(TeamMember selected) {
        if (selected == target) {
            prompt.setText(getString(R.string.correct_answer));
            prompt.postDelayed(this::chooseTarget, 700);
        } else {
            prompt.setText(getString(R.string.try_again, target.getName()));
        }
    }
}
