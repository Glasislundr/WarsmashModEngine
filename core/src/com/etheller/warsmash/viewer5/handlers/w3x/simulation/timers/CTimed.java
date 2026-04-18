package com.etheller.warsmash.viewer5.handlers.w3x.simulation.timers;

import com.etheller.warsmash.viewer5.handlers.w3x.simulation.CSimulation;

public interface CTimed {

	/**
	 * @param simulation
	 */
	void start(CSimulation simulation);

	void pause(CSimulation simulation);

	void kill(CSimulation simulation);

	void resume(CSimulation simulation);

	int getEngineFireTick();

	void fire(CSimulation simulation);

}