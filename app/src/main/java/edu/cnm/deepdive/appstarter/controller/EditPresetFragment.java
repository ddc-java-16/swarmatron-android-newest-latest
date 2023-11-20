package edu.cnm.deepdive.appstarter.controller;

import static android.os.Build.VERSION_CODES.R;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;
import edu.cnm.deepdive.appstarter.databinding.FragmentEditPresetBinding;
import edu.cnm.deepdive.appstarter.model.entity.Preset;
import edu.cnm.deepdive.appstarter.viewmodel.PresetViewModel;
import java.util.regex.Pattern;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

@AndroidEntryPoint
public class EditPresetFragment extends DialogFragment {
  private FragmentEditPresetBinding binding;
  private AlertDialog dialog;
  private PresetViewModel viewModel;
  private Preset preset;

  @NonNull
  @Override
  public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
    binding = FragmentEditPresetBinding.inflate(getLayoutInflater(), null, false);
    dialog = new Builder(requireContext())
        .setView(binding.getRoot())
        .create();

    viewModel= new ViewModelProvider(this).get(PresetViewModel.class);
    binding.savebutton.setOnClickListener((v) -> {
      preset = new Preset();
      preset.setPresetName(String.valueOf(binding.presetname.getText()));
      viewModel.save(preset);
    });
    return dialog;

  }

  @Nullable
  @Override
  public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

  }

  @Override
  public void onDestroyView() {
    binding = null;
    super.onDestroyView();
  }


}
