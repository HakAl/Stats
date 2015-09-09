package com.jacmobile.stats.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jacmobile.stats.R;
import com.jacmobile.stats.ui.view_items.StatsListItem;

import java.util.ArrayList;
import java.util.List;

public class StatsListAdapter extends BaseAdapter
{
    private ArrayList<StatsListItem> items;

    public StatsListAdapter(List<StatsListItem> items)
    {
        this.items = new ArrayList<>(items);
    }

    @Override public int getCount()
    {
        return items.size();
    }

    @Override public StatsListItem getItem(int position)
    {
        return items.get(position);
    }

    @Override public long getItemId(int position)
    {
        return position;
    }

    @Override public View getView(int position, View convertView, ViewGroup parent)
    {
        Context context = parent.getContext();
        ListItem item;
        StatsListItem listItem = items.get(position);

        if (convertView == null) {
            item = new ListItem();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.stats_card, parent, false);
            inflater.inflate(listItem.viewResId,
                    (ViewGroup) convertView.findViewById(R.id.parent_stats_card), false);
            item.title = (TextView) convertView.findViewById(listItem.titleResId);
            convertView.setTag(item);
        } else {
            item = (ListItem) convertView.getTag();
        }

        item.title.setText(context.getString(listItem.titleStringResId));

        return convertView;
    }

    static class ListItem
    {
        TextView title;
    }
}
