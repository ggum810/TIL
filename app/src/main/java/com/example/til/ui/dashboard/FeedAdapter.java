package com.example.til.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.til.PopupActivity;
import com.example.til.R;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {
    private Context mContext;
    private List<FeedItem> mFeedItems;

    public FeedAdapter(Context context, List<FeedItem> feedItems) {
        mContext = context;
        mFeedItems = feedItems;
    }

    @NonNull
    @Override
    public FeedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedViewHolder holder, int position) {
        final FeedItem feedItem = mFeedItems.get(position);
        holder.imageView.setImageResource(feedItem.getImageResource());

        // 아이템 클릭 이벤트 처리
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 클릭한 아이템의 이미지 리소스와 게시글 내용을 가져옵니다.
                int imageResource = feedItem.getImageResource();
                String postContent = "게시글 내용이 여기에 들어갑니다.";

                // 팝업 화면을 띄우기 위한 인텐트를 생성합니다.
                Intent intent = new Intent(mContext, PopupActivity.class);
                intent.putExtra("imageResource", imageResource);
                intent.putExtra("postContent", postContent);

                // 팝업 화면을 띄웁니다.
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mFeedItems.size();
    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public FeedViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}