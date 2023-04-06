package com.uncr.studioapp.mapper.wallet;

import com.uncr.studioapp.domain.wallet.WalletVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WalletMapper {
    void pairWallet(WalletVO walletVO);
    WalletVO getWallet(String walletAddress);
}
