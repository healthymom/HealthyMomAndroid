package kz.healthymom.presentation.account;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import de.hdodenhof.circleimageview.CircleImageView;
import kz.healthymom.R;
import kz.healthymom.presentation.faq.FaqFragment;
import kz.healthymom.presentation.utils.CustomCollapsingToolbarLayout;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class ProfileFragment extends Fragment {
    private InfoFragment faqFragment = new InfoFragment();

    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    private boolean isTitleShowing = false;
    private TextView titleName, toolbarName;
    private CircleImageView profileImage;
    private ImageView profileInfoIcon, settingsIcon;
    private String showingName = "";

    public ProfileFragment() {

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.f_account, container, false);
        showingName = "Толганай Салыкбаева";

        CustomCollapsingToolbarLayout collapsingToolbarLayout = root.findViewById(R.id.collapsing_toolbar);
        titleName = root.findViewById(R.id.title_name);
        toolbarName = root.findViewById(R.id.toolbar_name);
        profileInfoIcon = root.findViewById(R.id.profile_info);
        settingsIcon = root.findViewById(R.id.settings);
        profileInfoIcon.setOnClickListener(v -> openProfileInfo());
//        settingsIcon.setOnClickListener(v -> startActivity(new Intent(getContext(), SettingsActivity.class)));
        profileImage = root.findViewById(R.id.profile_image);

        collapsingToolbarLayout.setListener(showing -> {
            isTitleShowing = showing;
            if (showing) {
                titleName.setText(showingName);
                profileInfoIcon.setColorFilter(getResources().getColor(R.color.black));
                settingsIcon.setColorFilter(getResources().getColor(R.color.black));
            } else {
                titleName.setText("");
                profileInfoIcon.setColorFilter(getResources().getColor(R.color.white));
                settingsIcon.setColorFilter(getResources().getColor(R.color.white));
            }
        });

        TabLayout tabLayout = root.findViewById(R.id.tab);
        ViewPager viewPager = root.findViewById(R.id.pager);
        MainPagerAdapter adapter = new MainPagerAdapter(getChildFragmentManager());
        adapter.addFragment(faqFragment, "Основные данные");
//        adapter.addFragment(faqFragment);
        viewPager.setAdapter(adapter);
//        viewPager.setOffscreenPageLimit(4);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_account);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_account);

        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        switch (tab.getPosition()) {
                            case 0:
                                tabLayout.getTabAt(0).setIcon(R.drawable.ic_account);
                                break;
                            case 1:
                                tabLayout.getTabAt(1).setIcon(R.drawable.ic_account);
                                break;
                        }
                        tab.getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        switch (tab.getPosition()) {
                            case 0:
                                tabLayout.getTabAt(0).setIcon(R.drawable.ic_calendar);
                                break;
                            case 1:
                                tabLayout.getTabAt(1).setIcon(R.drawable.ic_calendar);
                                break;
                        }
                        tab.getIcon().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_IN);
                    }
                }
        );
        viewPager.setCurrentItem(2);
        return root;
    }

    private void openProfileInfo() {
//        ConstantUtil.showDialog(getContext());
//        Intent intent = new Intent(getContext(), EditProfileActivity.class);
//        startActivityForResult(intent, 4);
    }


}
