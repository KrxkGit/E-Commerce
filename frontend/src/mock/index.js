import Mock from 'mockjs'
import './user'

Mock.setup({ timeout: 300 })

export default Mock

Mock.mock('/user', {
    'ret': 200,
})