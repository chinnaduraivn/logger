package com.logger.registry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.logger.Level;
import com.logger.sink.Sink;

public final class Registry {

	private static HashMap<Level, List<Sink>> registry = new HashMap<>();

	public static void registerSink(Sink sink) {

		for (Level level : sink.getLevels()) {
			if (registry.containsKey(level))
				registry.get(level).add(sink);
			else {
				List<Sink> sinks = new ArrayList<>();
				sinks.add(sink);
				registry.put(level, sinks);
			}
		}
	}

	public static List<Sink> getSinksForLevel(Level level) {
		return Collections.unmodifiableList(registry.get(level));
	}
}
