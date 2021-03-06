package com.radyou.service;

import com.radyou.auth.AuthUtils;
import com.radyou.domain.Member;
import com.radyou.domain.User;
import com.radyou.domain.history.Call;
import com.radyou.domain.history.History;
import com.radyou.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional
public class HistoryService {

    @Autowired
    private AuthUtils authUtils;

    @Autowired
    private MemberRepository memberRepository;

    public History getHistoryFor(Principal principal) {
        User user = authUtils.getAuthenticatedUser(principal);

        History history = user.prepareHistory();

        fillUserNamesBaseOnRtcIds(history);

        return history;
    }

    private void fillUserNamesBaseOnRtcIds(History history) {
        for (Call call : history.getCalls()) {
            List<String> others = call.getOtherRtcIds().stream()
                    .map(memberRepository::getByRtcId)
                    .map(Member::getUsername)
                    .collect(toList());
            call.setOtherNames(others);
        }
    }

}
