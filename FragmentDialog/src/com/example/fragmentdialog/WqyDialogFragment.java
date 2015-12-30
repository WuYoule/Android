package com.example.fragmentdialog;

import java.util.Calendar;
import java.util.Date;

import android.R.integer;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.TimePicker.OnTimeChangedListener;

public class WqyDialogFragment extends DialogFragment {

	static WqyDialogFragment getInstance(int id) {
		WqyDialogFragment w = new WqyDialogFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("id", id);

		w.setArguments(bundle);
		return w;

	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		int id = getArguments().getInt("id");

		switch (id) {
		case R.id.alertdialog:
			return new AlertDialog.Builder(getActivity())
					.setIcon(R.drawable.ic_launcher).setTitle(getTag())
					.setPositiveButton("ok", new OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getActivity(), "你点击了ok",
									Toast.LENGTH_SHORT).show();
						}
					}).setNegativeButton("cancel", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							Toast.makeText(getActivity(), "你点击了cancel",
									Toast.LENGTH_SHORT).show();

						}
					}).create();

		case R.id.datedialog:
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			//java 中 用 0-11表示月份
			int monthOfYear = calendar.get(Calendar.MONTH);
			int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(getActivity(), new OnDateSetListener() {

				@Override
				public void onDateSet(DatePicker view, int year,
						int monthOfYear, int dayOfMonth) {
					Toast.makeText(getActivity(), year+"-"+(monthOfYear+1)+"-"+dayOfMonth,
							Toast.LENGTH_SHORT).show();
					
				TextView tView=	(TextView) getActivity().findViewById(R.id.content_tv);
				tView.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
				}
			}, year, monthOfYear, dayOfMonth);

		case R.id.timedialog:
			Calendar calendar1 = Calendar.getInstance();
			int hourOfDay = calendar1.get(Calendar.HOUR_OF_DAY);
			int minute = calendar1.get(Calendar.MINUTE);

			return new TimePickerDialog(getActivity(), new OnTimeSetListener() {

				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					Toast.makeText(getActivity(), hourOfDay+":"+minute,
							Toast.LENGTH_SHORT).show();
					//Fragment与其父Activity 通信
					TextView tView=	(TextView) getActivity().findViewById(R.id.content_tv);
					tView.setText(hourOfDay+":"+minute);
				}
			}, hourOfDay, minute, true);

		default:
			break;
		}
		return null;
	}

}
