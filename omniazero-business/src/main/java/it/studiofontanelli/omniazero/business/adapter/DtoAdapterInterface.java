package it.studiofontanelli.omniazero.business.adapter;



import java.io.Serializable;
import java.util.List;

import it.studiofontanelli.omniazero.business.exception.DtoConversionException;
import it.studiofontanelli.omniazero.util.Constants;

public interface DtoAdapterInterface <T,V> extends Serializable {


	public static final String LOGGER_PREFIX = Constants.LOGGER_PREFIX + ".adapter";

	public V convertTo(T t) throws DtoConversionException;

	public T convertFrom(V v) throws DtoConversionException ;

	public List<V> convertTo(List<T> tList) throws DtoConversionException ;

	public List<T> convertFrom(List<V> vList) throws DtoConversionException ;

}

