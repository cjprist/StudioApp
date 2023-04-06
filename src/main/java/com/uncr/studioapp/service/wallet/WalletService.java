package com.uncr.studioapp.service.wallet;

import com.uncr.studioapp.domain.wallet.WalletVO;
import com.uncr.studioapp.mapper.wallet.WalletMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class WalletService {
    final
    WalletMapper walletMapper;

    public WalletService(WalletMapper walletMapper) {
        this.walletMapper = walletMapper;
    }

    public void pariWallet(WalletVO walletVO){
        walletMapper.pairWallet(walletVO);
    }

    public WalletVO getWallet(String walletAddress){
        return walletMapper.getWallet(walletAddress);
    }
}
