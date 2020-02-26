package com.fiveone.shopsmart.suadmin.service;


import com.fiveone.shopsmart.suadmin.domain.Role;
import com.fiveone.shopsmart.suadmin.domain.entity.shopsmart_support.SaAccount;
import com.fiveone.shopsmart.suadmin.domain.repository.shopsmart_support.SaAccountRepository;
import com.fiveone.shopsmart.suadmin.dto.SaAccountRequestDto;
import com.fiveone.shopsmart.suadmin.dto.SaAccountResponseDto;
import lombok.AllArgsConstructor;
import org.hsqldb.lib.StringUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SaAccountService implements UserDetailsService {
    private SaAccountRepository saAccountRepository;

    @Transactional
    public Long getCount () {
        return saAccountRepository.count();
    }

    @Transactional
    public Long joinUser(SaAccountRequestDto saAccountRequestDto) {
        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        saAccountRequestDto.setPassword(passwordEncoder.encode(saAccountRequestDto.getPassword()));

        return saAccountRepository.save(saAccountRequestDto.toEntity()).getIdx();
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<SaAccount> userEntityWrapper = saAccountRepository.findByEmail(userEmail);
        SaAccount userEntity = userEntityWrapper.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (("playonflash@gmail.com").equals(userEmail)) {
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(Role.MEMBER.getValue()));
        }

        return new User (userEntity.getName(), userEntity.getPassword(), authorities);
    }



    @Transactional
    public List<SaAccountResponseDto> findAllByPageRequest (Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("idx").descending());
        return saAccountRepository.findAll(pageRequest)
                .map(SaAccountResponseDto::new).getContent();
    }

    @Transactional
    public void update (SaAccountRequestDto dto) {
        saAccountRepository.update (
                dto.getIdx(),
                dto.getEmail(),
                dto.getName()
        );


        if (!StringUtil.isEmpty(dto.getPassword())) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            saAccountRepository.update_password(
                    dto.getIdx(),
                    passwordEncoder.encode(dto.getPassword())
            );
        }
    }



}
