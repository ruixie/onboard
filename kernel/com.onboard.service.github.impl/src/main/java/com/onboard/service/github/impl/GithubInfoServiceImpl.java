/*******************************************************************************
 * Copyright [2015] [Onboard team of SERC, Peking University]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.onboard.service.github.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onboard.domain.mapper.GithubInfoMapper;
import com.onboard.domain.mapper.model.GithubInfoExample;
import com.onboard.domain.model.GithubInfo;
import com.onboard.service.github.GithubInfoService;

/**
 * {@link com.onboard.plugin.github.GithubInfoService} Service implementation
 * 
 * @generated_by_elevenframework
 * 
 */
@Transactional
@Service("githubInfoServiceBean")
public class GithubInfoServiceImpl implements GithubInfoService {

    @Autowired
    private GithubInfoMapper githubInfoMapper;

    @Override
    public GithubInfo getGithubInfoById(int id) {
        return githubInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<GithubInfo> getGithubInfos(int start, int limit) {
        GithubInfoExample example = new GithubInfoExample(new GithubInfo());
        example.setLimit(start, limit);
        return githubInfoMapper.selectByExample(example);
    }

    @Override
    public List<GithubInfo> getGithubInfosByExample(GithubInfo item, int start, int limit) {
        GithubInfoExample example = new GithubInfoExample(item);
        example.setLimit(start, limit);
        return githubInfoMapper.selectByExample(example);
    }

    @Override
    public int countByExample(GithubInfo item) {
        GithubInfoExample example = new GithubInfoExample(item);
        return githubInfoMapper.countByExample(example);
    }

    @Override
    public GithubInfo createGithubInfo(GithubInfo item) {
        githubInfoMapper.insert(item);
        return item;
    }

    @Override
    public GithubInfo updateGithubInfo(GithubInfo item) {
        githubInfoMapper.updateByPrimaryKey(item);
        return item;
    }

    @Override
    public void deleteGithubInfo(int id) {
        githubInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String getTokenByOnboardUserId(int onboardUserId) {
        GithubInfo githubInfo = new GithubInfo();
        githubInfo.setOnboardUserId(onboardUserId);
        GithubInfoExample example = new GithubInfoExample(githubInfo);
        example.setLimit(0, -1);
        List<GithubInfo> githubInfos = githubInfoMapper.selectByExample(example);

        if (githubInfos.size() != 0) {
            return githubInfos.get(0).getToken();
        }
        return null;
    }

    @Override
    public List<GithubInfo> getGithubInfoByUserId(int userId) {
        GithubInfo githubInfo = new GithubInfo();
        githubInfo.setUserId(userId);
        GithubInfoExample example = new GithubInfoExample(githubInfo);
        example.setLimit(0, -1);
        return githubInfoMapper.selectByExample(example);
    }

    @Override
    public void updateByPrimaryKeySelective(GithubInfo githubInfo) {

        githubInfoMapper.updateByPrimaryKeySelective(githubInfo);
    }

    @Override
    public String getCodeByOnboardUserId(int onboardUserId) {
        GithubInfo githubInfo = new GithubInfo();
        githubInfo.setOnboardUserId(onboardUserId);
        GithubInfoExample example = new GithubInfoExample(githubInfo);
        example.setLimit(0, -1);
        List<GithubInfo> githubInfos = githubInfoMapper.selectByExample(example);
        if (githubInfos.size() != 0) {
            return githubInfos.get(0).getCode();
        }
        return null;
    }

    @Override
    public GithubInfo getGithubInfoByOnboardUserId(int onboardUserId) {
        GithubInfo githubInfo = new GithubInfo();
        githubInfo.setOnboardUserId(onboardUserId);
        GithubInfoExample example = new GithubInfoExample(githubInfo);
        example.setLimit(0, -1);
        List<GithubInfo> githubInfos = githubInfoMapper.selectByExample(example);
        if (githubInfos.size() != 0) {
            return githubInfos.get(0);
        }
        return null;
    }

}
