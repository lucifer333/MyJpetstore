package com.langtaojin.myjpetstore.mapper;

import com.langtaojin.myjpetstore.domain.Sequence;

public interface SequenceMapper {

	Sequence getSequence(Sequence sequence);
	
	void updateSequence(Sequence sequence);
	
}
