package com.company.barracksWars.core.factories;

import com.company.barracksWars.contracts.Unit;
import com.company.barracksWars.contracts.UnitFactory;
import com.company.barracksWars.models.AbstractUnit;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"com.company.barracksWars.models.";

	@Override
	public Unit createUnit(String unitType){
        String packageName = AbstractUnit.class.getName();
        int index = packageName.lastIndexOf('.') + 1;
        String name = packageName.substring(0, index);
        Unit unit = null;
        try{
            Class unitClass = Class.forName(name + unitType);
            Constructor ctor = unitClass.getConstructor();
            unit = (Unit) ctor.newInstance();
        } catch (ReflectiveOperationException ex){
            ex.printStackTrace();
        }

        return unit;
	}
}
