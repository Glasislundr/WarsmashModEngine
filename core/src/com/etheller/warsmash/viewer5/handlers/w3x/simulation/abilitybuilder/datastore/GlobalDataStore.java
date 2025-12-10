package com.etheller.warsmash.viewer5.handlers.w3x.simulation.abilitybuilder.datastore;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GlobalDataStore implements DataStore {
	public static GlobalDataStore INSTANCE = new GlobalDataStore();

	private Map<String, Object> store;

	private GlobalDataStore() {
		this.store = new HashMap<>();
	}

	@Override
	public boolean containsKey(String key) {
		return store.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return store.containsValue(value);
	}

	@Override
	public Object get(String key) {
		return store.get(key);
	}

	@Override
	public Object getOrDefault(String key, Object def) {
		return store.getOrDefault(key, def);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T get(String key, Class<T> D) {
		Object val = store.get(key);
		if (val != null && D.isAssignableFrom(val.getClass())) {
			return (T) val;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getOrDefault(String key, T def, Class<T> D) {
		Object val = store.getOrDefault(key, def);
		if (val != null && D.isAssignableFrom(val.getClass())) {
			return (T) val;
		}
		return null;
	}

	@Override
	public Object put(String key, Object value) {
		return store.put(key, value);
	}

	@Override
	public Object remove(String key) {
		return store.remove(key);
	}

	@Override
	public void clear() {
		store.clear();
	}

	@Override
	public Set<String> keySet() {
		return store.keySet();
	}

	@Override
	public Collection<Object> values() {
		return store.values();
	}

}
