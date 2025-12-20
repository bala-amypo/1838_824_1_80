package com.example.demo.service;

import com.example.demo.entity.ClashRecord;
import java.util.List;

public interface ClashRecordService {

    public ClashRecord logClash(ClashRecord clashRecord);

    public ClashRecord resolveClash(Long id);

    public List<ClashRecord> getClashesByEventId(Long eventId);

    public List<ClashRecord> getUnresolvedClashes();

    public List<ClashRecord> getAllClashes();
}
