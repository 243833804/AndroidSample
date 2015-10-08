package small.net.core;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

public class xIntent {

	/*
	 * �������
	 */
	public static Intent WebBrower(String url) {

		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("http://w" + url));
		return intent;
	}

	/*
	 * �򿪵�ͼ����
	 */
	public static Intent Map(Double lng, Double lat) {

		Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("geo:" + lng + "," + lat));
		return intent;
	}

	/*
	 * �򿪲��Ŵ���
	 */
	public static Intent DIAL(String telPhoneNumber) {

		Intent intent = new Intent(android.content.Intent.ACTION_DIAL,
				Uri.parse("tel:+" + telPhoneNumber));
		return intent;
	}

	/*
	 * ����ϵ��
	 */
	public static Intent Contacts() {

		Intent intent = new Intent(android.content.Intent.ACTION_DIAL,
				Uri.parse("content://contacts"));
		return intent;
	}

	// CAPTURE
	/*
	 * �������
	 */
	public static Intent Capture() {

		// ���� REQUEST_CODE_TAKE_PICTURE Ϊ���صı�ʶ
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); // "android.media.action.IMAGE_CAPTURE";
		intent.putExtra(MediaStore.EXTRA_OUTPUT,
				Uri.parse("content://mms/scrapSpace")); // output,Uri.parse("content://mms/scrapSpace");
		return intent;
	}

	// ѡ��ͼƬ requestCode
	public static Intent SelectImage() {

		// ѡ��ͼƬ requestCode ���صı�ʶ
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT); // "android.intent.action.GET_CONTENT"
		intent.setType("image/*"); // �鿴���� String IMAGE_UNSPECIFIED = "image/*";
		Intent wrapperIntent = Intent.createChooser(intent, null);
		return wrapperIntent;
	}

	// ¼��
	public static Intent AudioAmr() {

		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("audio/amr"); // String AUDIO_AMR = "audio/amr";
		intent.setClassName("com.android.soundrecorder",
				"com.android.soundrecorder.SoundRecorder");
		return intent;
	}

	/*
	 * ������Ƶ
	 */
	public static Intent Player(String url) {

		Intent intent = new Intent(Intent.ACTION_VIEW);
		Uri uri = Uri.parse(url);
		intent.setDataAndType(uri, "video/*");
		return intent;
	}

	/*
	 * ������Ƶ
	 */
	public static Intent Video() {

		Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
		intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
		return intent;

	}

	/*
	 * ѡ����Ƶ
	 */
	public static Intent SelectVIDEO() {

		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType("video/*"); // String VIDEO_UNSPECIFIED = "video/*";
		Intent wrapperIntent = Intent.createChooser(intent, null);
		return wrapperIntent;
	}

	/*
	 * ����Ϣ
	 */
	public static Intent SendMessage(String number, String content) {

		Uri uri = Uri.parse("smsto:" + number);
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
		intent.putExtra("sms_body", content);
		return intent;
	}
}
