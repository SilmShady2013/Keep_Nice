package com.evilsoulm.keep_nice.domain.base;

/**
 * Author by EvilsoulM
 * Data:2016-05-05 14:24
 * Project:Keep_Nice
 * Detail:
 */
public abstract class BaseUseCase<T extends BaseDataPrvdr> {
    protected T prvdr;

    public BaseUseCase() {
        prvdr = getPrvdr();
    }

    public abstract T getPrvdr();
}
