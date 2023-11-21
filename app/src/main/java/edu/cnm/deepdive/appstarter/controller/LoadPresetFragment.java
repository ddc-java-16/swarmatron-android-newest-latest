package edu.cnm.deepdive.appstarter.controller;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.appstarter.databinding.ActivityMainBinding;
import edu.cnm.deepdive.appstarter.databinding.FragmentLoadPresetBinding;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.viewmodel.PresetViewModel;
import java.util.ArrayList;
import java.util.List;

@AndroidEntryPoint
public class LoadPresetFragment extends DialogFragment implements LifecycleOwner {

  AlertDialog dialog;
  FragmentLoadPresetBinding binding;
  ActivityMainBinding mainBinding;
  PresetViewModel viewModel;
  List<String> presetnames;

  @NonNull
  @Override
  public Dialog onCreateDialog(
      @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    binding = FragmentLoadPresetBinding.inflate(getLayoutInflater(), null, false);
    //mainBinding = ActivityMainBinding.inflate(getLayoutInflater(), null, false);

    binding.presetlist.setOnItemClickListener((parent, view, position, id) -> {
      Preset preset = (Preset) parent.getItemAtPosition(position);
      viewModel.fetch(preset.getId());
      dismiss();
    });

    dialog = new Builder(requireContext())
        .setView(binding.getRoot())
        .create();

    return dialog;
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(requireActivity()).get(PresetViewModel.class);
    viewModel.getAllPresets().observe(this, presets -> {

      binding.presetlist.setAdapter(
          new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,
              presets));
    });
  }
}
