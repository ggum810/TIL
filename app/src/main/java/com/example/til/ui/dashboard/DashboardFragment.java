package com.example.til.ui.dashboard;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.til.R;
import com.example.til.databinding.FragmentDashboardBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private RecyclerView mRecyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mRecyclerView = root.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3)); // 3열의 그리드
        mRecyclerView.addItemDecoration(new GridSpacingItemDecoration(3, 0, true)); // 간격 없애기

        List<FeedItem> feedItems = generateFeedItems(24); // 24개의 무작위 피드 생성

        FeedAdapter adapter = new FeedAdapter(requireContext(), feedItems);
        mRecyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List<FeedItem> generateFeedItems(int count) {
        List<FeedItem> feedItems = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomImageResource = getRandomImageResource();
            FeedItem feedItem = new FeedItem(randomImageResource);
            feedItems.add(feedItem);
        }

        return feedItems;
    }

    private int getRandomImageResource() {
        int[] imageResources = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8};
        Random random = new Random();
        return imageResources[random.nextInt(imageResources.length)];
    }
}