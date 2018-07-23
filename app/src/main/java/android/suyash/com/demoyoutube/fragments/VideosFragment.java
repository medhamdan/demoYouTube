package android.suyash.com.demoyoutube.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.suyash.com.demoyoutube.R;
import android.suyash.com.demoyoutube.activities.MainActivity;
import android.suyash.com.demoyoutube.activities.YoutubePlayerActivity;
import android.suyash.com.demoyoutube.adapter.YoutubeVideoAdapter;
import android.suyash.com.demoyoutube.model.YoutubeVideoModel;
import android.suyash.com.demoyoutube.utis.RecyclerViewOnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.youtube.player.YouTubeBaseActivity;

import java.util.ArrayList;

public class VideosFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.activity_main, container, false);
        setUpRecyclerView(view);
        populateRecyclerView();
        return view;


    }

    private void populateRecyclerView() {
        final ArrayList<YoutubeVideoModel> youtubeVideoModelArrayList = generateDummyVideoList();
        YoutubeVideoAdapter adapter = new YoutubeVideoAdapter(getContext(), youtubeVideoModelArrayList);
        recyclerView.setAdapter(adapter);

        //set click event
        recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(getContext(), new RecyclerViewOnClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                //start youtube player activity by passing selected video id via intent
                startActivity(new Intent(getActivity(), YoutubePlayerActivity.class)
                        .putExtra("video_id", youtubeVideoModelArrayList.get(position).getVideoId()));

            }
        }));
    }

    private void setUpRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    private ArrayList<YoutubeVideoModel> generateDummyVideoList() {
        ArrayList<YoutubeVideoModel> youtubeVideoModelArrayList = new ArrayList<>();

        //get the video id array, title array and duration array from strings.xml
        String[] videoIDArray = getResources().getStringArray(R.array.video_id_array);
        String[] videoTitleArray = getResources().getStringArray(R.array.video_title_array);
        String[] videoDurationArray = getResources().getStringArray(R.array.video_duration_array);

        //loop through all items and add them to arraylist
        for (int i = 0; i < videoIDArray.length; i++) {

            YoutubeVideoModel youtubeVideoModel = new YoutubeVideoModel();
            youtubeVideoModel.setVideoId(videoIDArray[i]);
            youtubeVideoModel.setTitle(videoTitleArray[i]);
            youtubeVideoModel.setDuration(videoDurationArray[i]);

            youtubeVideoModelArrayList.add(youtubeVideoModel);

        }

        return youtubeVideoModelArrayList;
    }
}
