package hmm.itam.service;

import hmm.itam.mapper.AssetMapper;
import hmm.itam.vo.AssetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetMapper AssetMapper;


    public List<AssetVo> getAssetList() {

        return AssetMapper.getAssetList();
    }



    /*장비 정보 등록*/
    public void assetAdd(AssetVo assetVo){AssetMapper.insertAsset(assetVo);}

    /*멤버 장비 사용 정보 조회*/
    public List<AssetVo> memberSearch(String statusMemberId) {
        return AssetMapper.searchByMember(statusMemberId);
    }


    /*장비 조회 1*/
    public AssetVo assetSearch(String assetNumber) {
        return AssetMapper.getAssetByAssetNumber(assetNumber);
    }

    /*장비정보 수정*/
    public void modifyInfo(AssetVo assetVo) { AssetMapper.updateAsset(assetVo);}

    /*장비 삭제하기*/
    public void withdraw(AssetVo assetVo) {
        AssetMapper.deleteAsset(assetVo);
    }

}

