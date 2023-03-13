package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 방금그곡 {

	//음악 제목, 재생이 시작되고 끝난 시각, 악보를 제공
	// C, C#, D, D#, E, F, F#, G, G#, A, A#, B  음은 12개
	// 각 음은 1분에 1개씩 재생
	// 음악은 처음부터 재생되며 음악 길이보다 재생된 시간이 길 때는 반복재생
	// 음악이 더 길면 재생시간 만큼만 재생
	// 여러개 음악이 일치할경우 재생된 시간이 제일 긴 음악 제목 반환, 재생된 시간이 같으면 먼저 입력된 음악 제목
	// 일치하는 음악이 없는 경우 (None) 반환

	public static String solution(String m, String[] musicinfos) {
		List<Music> list = init(musicinfos);
		List<Music> ansList = new ArrayList<>();
		m = Music.substitution(m);
		for (Music music : list) {
			if (music.sound.contains(m)) {
				ansList.add(music);
			}
		}

		if (ansList.isEmpty()) {
			return "(None)";
		}

		if (ansList.size() > 2) {
			ansList.sort((o1, o2) -> {
				int c = o2.playMin - o1.playMin;
				if (c == 0) {
					return o1.playMin;
				}
				return c;
			});

		}

		return ansList.get(0).title;
	}

	private static List<Music> init(String[] musicinfos) {
		List<Music> list = new ArrayList<>();
		StringTokenizer st;
		for (int i = 0; i < musicinfos.length; i++) {
			st = new StringTokenizer(musicinfos[i], ",");
			list.add(new Music(st.nextToken(), st.nextToken(), st.nextToken(), Music.substitution(st.nextToken())));
		}

		return list;
	}

	private static class Music {
		int playMin;
		String title;
		String sound;

		public Music(String startTime, String endTime, String title, String sound) {
			this.playMin = getPlayMin(startTime, endTime);
			this.title = title;
			this.sound = getSound(playMin, sound);
		}

		private static String getSound(int playMin, String sound) {
			if (sound.length() == playMin) {
				return sound;
			}

			if (sound.length() < playMin) {
				while (sound.length() < playMin) {
					sound += sound;
				}
				if (sound.length() == playMin) {
					return sound;
				}
			}
			return sound.substring(0, playMin);
		}

		private static String substitution(String sound) {
			return sound.replace("C#", "c")
				.replace("D#", "d")
				.replace("F#", "f")
				.replace("G#", "g")
				.replace("A#", "a");
		}

		private static int getPlayMin(String startTime, String endTime) {
			String[] startTimeSplit = startTime.split(":");
			String[] endTimeSplit = endTime.split(":");
			int startMin = (Integer.parseInt(startTimeSplit[0]) * 60) + Integer.parseInt(startTimeSplit[1]);
			int endMin = (Integer.parseInt(endTimeSplit[0]) * 60) + Integer.parseInt(endTimeSplit[1]);

			return endMin - startMin;
		}
	}

	public static void main(String[] args) {
		System.out.println(solution("ABCDEFG", new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
		System.out.println(
			solution("CC#BCC#BCC#BCC#B", new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
		System.out.println(solution("ABC", new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));

		System.out.println(solution("CC#BCC#BCC#", new String[] {"03:00,03:08,FOO,CC#B"}));

	}

}
