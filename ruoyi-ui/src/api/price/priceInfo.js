import request from '@/utils/request'

// 查询样品价格信息列表
export function listPriceInfo(query) {
  return request({
    url: '/price/priceInfo/list',
    method: 'get',
    params: query
  })
}

// 查询样品价格信息详细
export function getPriceInfo(id) {
  return request({
    url: '/price/priceInfo/' + id,
    method: 'get'
  })
}

// 新增样品价格信息
export function addPriceInfo(data) {
  return request({
    url: '/price/priceInfo',
    method: 'post',
    data: data
  })
}

// 修改样品价格信息
export function updatePriceInfo(data) {
  return request({
    url: '/price/priceInfo',
    method: 'put',
    data: data
  })
}

// 删除样品价格信息
export function delPriceInfo(id) {
  return request({
    url: '/price/priceInfo/' + id,
    method: 'delete'
  })
}
