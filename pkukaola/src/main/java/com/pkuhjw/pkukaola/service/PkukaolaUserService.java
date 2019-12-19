package com.pkuhjw.pkukaola.service;

import com.github.pagehelper.PageHelper;
import com.pkuhjw.pkukaola.dao.PkukaolaUserMapper;
import com.pkuhjw.pkukaola.domain.PkukaolaUser;
import com.pkuhjw.pkukaola.domain.PkukaolaUserExample;
import com.pkuhjw.pkukaola.domain.UserVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PkukaolaUserService {
    @Resource
    private PkukaolaUserMapper userMapper;

    public PkukaolaUser findById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public UserVo findUserVoById(Integer userId) {
        PkukaolaUser user = findById(userId);
        UserVo userVo = new UserVo();
        userVo.setNickname(user.getNickname());
        userVo.setAvatar(user.getAvatar());
        return userVo;
    }

    public PkukaolaUser queryByOid(String openId) {
        PkukaolaUserExample example = new PkukaolaUserExample();
        example.or().andWeixinOpenidEqualTo(openId).andDeletedEqualTo(false);
        return userMapper.selectOneByExample(example);
    }

    public void add(PkukaolaUser user) {
        user.setAddTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        userMapper.insertSelective(user);
    }

    public int updateById(PkukaolaUser user) {
        user.setUpdateTime(LocalDateTime.now());
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<PkukaolaUser> querySelective(String username, String mobile, Integer page, Integer size, String sort, String order) {
        PkukaolaUserExample example = new PkukaolaUserExample();
        PkukaolaUserExample.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }
        if (!StringUtils.isEmpty(mobile)) {
            criteria.andMobileEqualTo(mobile);
        }
        criteria.andDeletedEqualTo(false);

        if (!StringUtils.isEmpty(sort) && !StringUtils.isEmpty(order)) {
            example.setOrderByClause(sort + " " + order);
        }

        PageHelper.startPage(page, size);
        return userMapper.selectByExample(example);
    }

    public int count() {
        PkukaolaUserExample example = new PkukaolaUserExample();
        example.or().andDeletedEqualTo(false);

        return (int) userMapper.countByExample(example);
    }

    public List<PkukaolaUser> queryByUsername(String username) {
        PkukaolaUserExample example = new PkukaolaUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public boolean checkByUsername(String username) {
        PkukaolaUserExample example = new PkukaolaUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return userMapper.countByExample(example) != 0;
    }

    public List<PkukaolaUser> queryByMobile(String mobile) {
        PkukaolaUserExample example = new PkukaolaUserExample();
        example.or().andMobileEqualTo(mobile).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public List<PkukaolaUser> queryByOpenid(String openid) {
        PkukaolaUserExample example = new PkukaolaUserExample();
        example.or().andWeixinOpenidEqualTo(openid).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public void deleteById(Integer id) {
        userMapper.logicalDeleteByPrimaryKey(id);
    }
}

