package android.suyash.com.demoyoutube.holder;

import android.support.v7.widget.RecyclerView;
import android.suyash.com.demoyoutube.R;
import android.view.View;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeThumbnailView;

public class YoutubeViewHolder extends RecyclerView.ViewHolder {

    public YouTubeThumbnailView videoThumbnailImageView;
    public TextView videoTitle, videoDuration;

    public YoutubeViewHolder(View itemView) {
        super(itemView);
        videoThumbnailImageView = itemView.findViewById(R.id.video_thumbnail_image_view);
        videoTitle = itemView.findViewById(R.id.video_title_label);
        videoDuration = itemView.findViewById(R.id.video_duration_label);
    }
}