package edu.cnm.deepdive.appstarter.controller;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.appstarter.R;
import edu.cnm.deepdive.appstarter.databinding.FragmentEditPresetBinding;
import edu.cnm.deepdive.appstarter.databinding.FragmentLoadPresetBinding;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.viewmodel.PresetViewModel;
import java.util.ArrayList;
import java.util.List;

@AndroidEntryPoint
public class LoadPresetFragment extends DialogFragment implements LifecycleOwner {

  AlertDialog dialog;
  FragmentLoadPresetBinding binding;
  PresetViewModel viewModel;

  @NonNull
  @Override
  public Dialog onCreateDialog(
      @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
    binding = FragmentLoadPresetBinding.inflate(getLayoutInflater(), null, false);
    viewModel = new ViewModelProvider(requireActivity()).get(PresetViewModel.class);
    viewModel.getAllPresets().observe(this, presets -> {
      List<String> presetnames = new ArrayList<>();
      for (Preset preset : presets) {
        presetnames.add(preset.getPresetName());

      }

      binding.presetlist.setAdapter(
          new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1,
              presetnames));
    });
    dialog = new Builder(requireContext())
        .setView(binding.getRoot())
        .create();

    return dialog;
  }
}
